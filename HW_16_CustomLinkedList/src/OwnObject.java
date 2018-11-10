import java.util.Random;

public class OwnObject {
    int info;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OwnObject ownObject = (OwnObject) o;

        return info == ownObject.info;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }
}
