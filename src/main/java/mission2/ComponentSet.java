package mission2;

import java.util.HashMap;
import java.util.Map;

public class ComponentSet {
    Map<String, Component> components;

    public ComponentSet() {
        this.components = new HashMap<>();
    }

    public Map<String, Component> getFullComponents() {
        return components;
    }

    public Component getEachComponent(String componentName) {
        return components.get(componentName);
    }

    public void setComponents(String componentName, Component component) {
        components.put(componentName, component);
    }
}
