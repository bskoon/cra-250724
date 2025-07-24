package mission2;

import java.util.HashMap;
import java.util.Map;

public class ComponentSet {
    private Map<String, String> components;

    public ComponentSet() {
        this.components = new HashMap<>();
    }

    public String getEachComponent(String componentName) {
        return components.get(componentName);
    }

    public void setComponents(String componentName, String typeName) {
        components.put(componentName, typeName);
    }
}
