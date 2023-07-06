package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int MAX_SIZE = 10000;
    private final Resume[] storage = new Resume[MAX_SIZE];
    private int size;


    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Save. Resume exist with same uuid: " + r.getUuid());
                return;
            }
        }
        if (size < MAX_SIZE) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Save. Storage is crowded");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Get. Resume not found for uuid: " + uuid);
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                size--;
                storage[size] = null;
                return;
            }
        }
        System.out.println("Delete. Resume not found for uuid: " + uuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(resume.getUuid())) {
                storage[i].setUuid(resume.getUuid()); // something update
                return;
            }
        }
        System.out.println("Update. Resume not found for uuid: " + resume.getUuid());
    }
}
