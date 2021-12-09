package com.github.felhag.intellijtypescriptimportorder.ui

import com.github.felhag.intellijtypescriptimportorder.Settings
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import org.apache.commons.lang.StringUtils
import javax.swing.JPanel


class SettingsComponent {
    var panel: JPanel? = null

    private val jenkinsUrl = JBTextField()
    private val bitbucketUrl = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent("Jenkins URL", jenkinsUrl)
            .addLabeledComponent("Bitbucket URL", bitbucketUrl)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun isModified(): Boolean {
        val current = Settings.get()
        val equal = StringUtils.equals(jenkinsUrl.text, current.jenkinsUrl) && StringUtils.equals(bitbucketUrl.text, current.bitbucketUrl)
        return !equal
    }

    fun apply() {
        val current = Settings.get()
        current.jenkinsUrl = jenkinsUrl.text
        current.bitbucketUrl = bitbucketUrl.text
    }

    fun reset() {
        val current = Settings.get()
        jenkinsUrl.text = current.jenkinsUrl
        bitbucketUrl.text = current.bitbucketUrl
    }
}
