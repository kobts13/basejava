/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int n = 0;
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            if (storage[i].uuid.equals(uuid)) {
                n = i;
            }
            if (i >= n) {
                storage[i] = storage[i + 1];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
        return resumes;
    }

    int size() {
        int size = 0;
        for (int i = 0; i < storage.length && storage[i] != null; i++) {
            size++;
        }
        return size;
    }
}
