
/**
 *
 * @author sooryaprasath
 */
public class Levels {

    public int levelId;
    public String levelName;

    public Levels(int id, String name) {
        this.levelId = id;
        this.levelName = name;
    }

    public int getId() {
        return this.levelId;
    }

    public String getBlockname() {
        return this.levelName;
    }

}
