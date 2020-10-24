package in.finertia.fisheries.model;

import android.graphics.drawable.Drawable;

import in.finertia.fisheries.enums.MenuServiceType;

public class MenuModel {

    private MenuServiceType menuServiceType;
    private String menuName;
    private String menuIconName;
    private Drawable menuIcon;

    public MenuServiceType getMenuServiceType() {
        return menuServiceType;
    }

    public void setMenuServiceType(MenuServiceType menuServiceType) {
        this.menuServiceType = menuServiceType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIconName() {
        return menuIconName;
    }

    public void setMenuIconName(String menuIconName) {
        this.menuIconName = menuIconName;
    }

    public Drawable getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(Drawable menuIcon) {
        this.menuIcon = menuIcon;
    }
}
