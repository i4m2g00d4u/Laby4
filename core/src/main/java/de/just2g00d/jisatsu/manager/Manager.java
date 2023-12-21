package de.just2g00d.jisatsu.manager;

import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.property.Property;
import net.labymod.api.util.function.ChangeListener;
import java.util.HashMap;
import java.util.Map;

public class Manager {

  public static Manager manager;

  private Map<Class, ManagerClass> managers;

  public Manager() {
    manager = this;
    managers = new HashMap<>();

  }

  public void addManager(Class managerClass, ConfigProperty<Boolean> switchSetting) {
    if(!switchSetting.get()) {
      managers.put(managerClass, null);
    } else {
      try {
        ManagerClass manager = (ManagerClass) managerClass.newInstance();
        managers.put(managerClass, manager);
        manager.onEnable();
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }
    switchSetting.addChangeListener(new ChangeListener<Property<Boolean>, Boolean>() {
      @Override
      public void changed(Property<Boolean> type, Boolean oldValue, Boolean newValue) {
        setEnabled(managerClass, newValue);
      }
    });
  }

  public void setEnabled(Class clazz, boolean enabled) {
    if(enabled) {
      try {
        ManagerClass manager = (ManagerClass) clazz.newInstance();
        managers.put(clazz, manager);
        manager.onEnable();
      } catch (InstantiationException e) {
        throw new RuntimeException(e);
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    } else {
      managers.get(clazz).onDisable();
      managers.put(clazz, null);
    }
  }

  public boolean isActive(Class managerClass) {
    return (managers.containsKey(managerClass) && managers.get(managerClass) != null);
  }

  public ManagerClass getManagerByClass(Class managerClass) {
    if(!managers.containsKey(managerClass)) return null;
    return managers.get(managerClass);
  }

  public Map<Class, ManagerClass> getManagers() {
    return managers;
  }


}
