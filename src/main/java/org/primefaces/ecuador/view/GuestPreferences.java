/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.ecuador.view;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class GuestPreferences implements Serializable {

    private String menuMode = "layout-menu-static";

    private String theme = "blue";

    private String layout = "blue";

    private boolean lightMenu = false;

    private boolean orientationRTL;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMenuMode() {
        String mode = menuMode;
        if (this.isLightMenu()) {
            mode = mode + " layout-menu-light";
        }

        return mode;
    }

    public void changeTheme(String value) {
        this.theme = value;

        if (value.indexOf("-") != -1) {
            this.layout = value.split("-")[0];
        } else {
            this.layout = value;
        }
    }

    public boolean isLightMenu() {
        return this.lightMenu;
    }

    public void setLightMenu(boolean lightMenu) {
        this.lightMenu = lightMenu;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;
    }

    public boolean isOrientationRTL() {
        return orientationRTL;
    }

    public void setOrientationRTL(boolean orientationRTL) {
        this.orientationRTL = orientationRTL;
    }
}
