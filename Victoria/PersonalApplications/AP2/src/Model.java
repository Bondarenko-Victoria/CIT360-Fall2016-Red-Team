import java.util.*;

public class Model {
    private HashMap<String, Bean> hash = new HashMap<>();

    public void addPerson(String key, Bean bean)
    {
        hash.put(key, bean);
    }

    public Map getAllPersons()
    {
        TreeMap sorted = new TreeMap(this.hash);
        return sorted;
    }

    public Bean getPersonsByFirstName(String firstName) {
        return hash.get(firstName);
    }
}