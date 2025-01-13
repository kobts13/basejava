package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) {
        showResume(createResume());
    }

    public static Resume createTestResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");

        Section objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSection(SectionType.OBJECTIVE, objective);

        Section personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSection(SectionType.PERSONAL, personal);

        Section achievement = getAchievement();
        resume.setSection(SectionType.ACHIEVEMENT, achievement);

        Section qualification = getSection();
        resume.setSection(SectionType.QUALIFICATIONS, qualification);

        List<Organization> companies = new ArrayList<>();
        List<Organization.Position> companyPeriods = new ArrayList<>();
        companyPeriods.add(new Organization.Position(DateUtil.of(2013, Month.OCTOBER),
                LocalDate.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        companies.add(new Organization("Java Online Projects", "http://javaops.ru/", companyPeriods));
        Section experience = new OrganizationSection(companies);
        resume.setSection(SectionType.EXPERIENCE, experience);

        List<Organization> schools = new ArrayList<>();
        List<Organization.Position> schoolsPeriods = new ArrayList<>();
        schoolsPeriods.add(new Organization.Position(DateUtil.of(2013, Month.MARCH),
                DateUtil.of(2013, Month.MAY),
                "'Functional Programming Principles in Scala' by Martin Odersky", ""));
        schools.add(new Organization("Coursera",
                "https://www.coursera.org/course/progfun",
                schoolsPeriods));
        Section education = new OrganizationSection(schools);
        resume.setSection(SectionType.EDUCATION, education);

        return resume;
    }

    private static Resume createResume() {
        Resume resume = new Resume("Григорий Кислин");

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContact(ContactType.MAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.STATCKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.setContact(ContactType.HOME_PAGE, "http://gkislin.ru/");

        Section objective = new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSection(SectionType.OBJECTIVE, objective);

        Section personal = new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSection(SectionType.PERSONAL, personal);

        Section achievement = getAchievement();
        resume.setSection(SectionType.ACHIEVEMENT, achievement);


        Section qualification = getSection();
        resume.setSection(SectionType.QUALIFICATIONS, qualification);

        List<Organization> companies = new ArrayList<>();
        List<Organization.Position> companyPeriods = new ArrayList<>();
        companyPeriods.add(new Organization.Position(DateUtil.of(2013, Month.OCTOBER),
                LocalDate.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        companies.add(new Organization("Java Online Projects", "http://javaops.ru/", companyPeriods));
        Section experience = new OrganizationSection(companies);
        resume.setSection(SectionType.EXPERIENCE, experience);

        List<Organization> schools = new ArrayList<>();
        List<Organization.Position> schoolsPeriods = new ArrayList<>();
        schoolsPeriods.add(new Organization.Position(DateUtil.of(2013, Month.MARCH),
                DateUtil.of(2013, Month.MAY),
                "'Functional Programming Principles in Scala' by Martin Odersky", ""));
        schools.add(new Organization("Coursera",
                "https://www.coursera.org/course/progfun",
                schoolsPeriods));
        Section education = new OrganizationSection(schools);
        resume.setSection(SectionType.EDUCATION, education);

        return resume;
    }

    private static Section getAchievement() {
        List<String> achievements = new ArrayList<>();
        achievements.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        return new ListSection(achievements);
    }

    private static Section getSection() {
        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");
        return new ListSection(qualifications);
    }

    private static void showResume(Resume resume) {
        System.out.println(resume.getFullName());

        System.out.println();
        for (ContactType contactType : ContactType.values()) {
            System.out.println(contactType.getTitle() + ": " + resume.getContact(contactType));
        }

        System.out.println();
        for (SectionType sectionType : SectionType.values()) {
            System.out.println(sectionType.getTitle());
            System.out.println(resume.getSection(sectionType));
        }
    }
}
