package com.github.felhag.intellijtypescriptimportorder

import com.github.felhag.intellijtypescriptimportorder.ui.SettingsComponent
import com.intellij.openapi.options.Configurable
import javax.swing.JComponent

class SettingsConfigurer : Configurable {
    private var settingsComponent: SettingsComponent? = null

    override fun getDisplayName(): String {
        return "Typescript Import Order"
    }

    override fun createComponent(): JComponent? {
        settingsComponent = SettingsComponent()
        return settingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        return settingsComponent!!.isModified()
    }

    override fun apply() {
        settingsComponent!!.apply()
    }

    override fun reset() {
        settingsComponent!!.reset()
    }

    override fun disposeUIResources() {
        settingsComponent = null
    }
}
