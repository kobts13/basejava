package ru.javawebinar.basejava.storage.serializer;

import ru.javawebinar.basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    private static String toNullIfLiteral(String str) {
        return "null".equals(str) ? null : str;
    }

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, Section> sections = r.getSections();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                Section section = entry.getValue();
                if (section instanceof TextSection) {
                    TextSection textSection = (TextSection) section;
                    dos.writeUTF(textSection.getClass().getName());
                    dos.writeUTF(textSection.getContent());
                } else if (section instanceof ListSection) {
                    ListSection listSection = (ListSection) section;
                    dos.writeUTF(listSection.getClass().getName());
                    List<String> items = listSection.getItems();
                    dos.writeInt(items.size());
                    for (String item : items) {
                        dos.writeUTF(item);
                    }
                } else if (section instanceof OrganizationSection) {
                    OrganizationSection organizationSection = (OrganizationSection) section;
                    dos.writeUTF(organizationSection.getClass().getName());
                    List<Organization> organizations = organizationSection.getOrganizations();
                    dos.writeInt(organizations.size());
                    for (Organization organization : organizations) {
                        Link homePage = organization.getHomePage();
                        dos.writeUTF(homePage.getName());
                        dos.writeUTF(String.valueOf(homePage.getUrl()));
                        List<Organization.Position> positions = organization.getPositions();
                        dos.writeInt(positions.size());
                        for (Organization.Position position : positions) {
                            dos.writeUTF(position.getStartDate().toString());
                            dos.writeUTF(position.getEndDate().toString());
                            dos.writeUTF(position.getTitle());
                            dos.writeUTF(String.valueOf(position.getDescription()));
                        }
                    }
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            size = dis.readInt();
            for (int i = 0; i < size; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                String className = dis.readUTF();
                if (className.equals(TextSection.class.getName())) {
                    resume.addSection(sectionType, new TextSection(dis.readUTF()));
                } else if (className.equals(ListSection.class.getName())) {
                    int itemSize = dis.readInt();
                    String[] items = new String[itemSize];
                    for (int j = 0; j < itemSize; j++) {
                        items[j] = dis.readUTF();
                    }
                    resume.addSection(sectionType, new ListSection(items));
                } else if (className.equals(OrganizationSection.class.getName())) {
                    int organisationSize = dis.readInt();
                    Organization[] organizations = new Organization[organisationSize];
                    for (int j = 0; j < organisationSize; j++) {
                        String name = dis.readUTF();
                        String url = toNullIfLiteral(dis.readUTF());
                        int positionSize = dis.readInt();
                        Organization.Position[] positions = new Organization.Position[positionSize];
                        for (int k = 0; k < positionSize; k++) {
                            positions[k] = new Organization.Position(
                                    LocalDate.parse(dis.readUTF()),
                                    LocalDate.parse(dis.readUTF()),
                                    dis.readUTF(),
                                    toNullIfLiteral(dis.readUTF()));
                        }
                        organizations[j] = new Organization(name, url, positions);
                    }
                    resume.addSection(sectionType, new OrganizationSection(organizations));
                }
            }
            return resume;
        }
    }
}
