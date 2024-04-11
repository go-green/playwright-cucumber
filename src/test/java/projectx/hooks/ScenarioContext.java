/**
 * @author Rasika Ranawaka
 * @filename Context
 * @date 11/04/2024
 */
package projectx.hooks;


import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * Initialise a scenario context objects using reflection. These objects are used to share the context between
 * BDD steps. The ScenarioContext class is constructor injected to step classes.
 */
public class ScenarioContext {

    private Map<String, Object> scenarioContext;

    public <T> T get(Class<T> clazz) {
        try {
            String name = clazz.getSimpleName();
            if (!scenarioContext.containsKey(name)) {
                Constructor constructor = clazz.getConstructor();
                scenarioContext.put(name, clazz.cast(constructor.newInstance()));
            }
            return (T) scenarioContext.get(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
