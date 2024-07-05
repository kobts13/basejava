package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<Integer, Resume> storage = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        int index = -1;
        for (Map.Entry<Integer, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(new Resume(uuid))) {
                index = entry.getKey();
            }
        }
        return index;
    }

    @Override
    protected void setResume(int index, Resume resume) {
        storage.put(index, resume);
    }

    @Override
    protected void deleteElement(int index, String uuid) {
        storage.remove(index);
    }

    @Override
    protected Resume get(int index) {
        return storage.get(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            storage.put(storage.size(), r);
        }
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
