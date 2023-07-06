package family_tree;

import java.io.Serializable;

public interface LoadFrom {
    Serializable load(String path);
}
