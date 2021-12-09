package com.github.felhag.intellijtypescriptimportorder

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(name = "TypescriptImportOrder", storages = [Storage("typescript_import_order.xml")])
class Settings : PersistentStateComponent<Settings> {
    var jenkinsUrl: String? = ""
    var bitbucketUrl: String? = ""

    override fun loadState(state: Settings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    override fun getState(): Settings {
        return this
    }

    companion object {
        fun get(): Settings = ApplicationManager.getApplication().getService(Settings::class.java)
    }
}
