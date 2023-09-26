package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void saveIfExist(int index, Resume r) {
        int position = Math.abs(index + 1);
        for (int i = size - 1; i >= position; i--) {
            storage[i + 1] = storage[i];
        }
        storage[position] = r;
        size++;
    }

    @Override
    protected void deleteIfExist(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
