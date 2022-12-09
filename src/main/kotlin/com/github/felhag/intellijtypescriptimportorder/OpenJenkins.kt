package com.github.felhag.intellijtypescriptimportorder

import org.apache.commons.lang.StringUtils

class OpenJenkins : OpenAction() {
    override fun buildUrl(project: String, repo: String): String {
        var url = StringUtils.removeEnd(Settings.get().jenkinsUrl, "/")
        if ("ART" == project) {
            url = url.replace("jenkins2", "jenkins2-at");
        }
        return "${url}/job/$project/job/$repo"
    }
}
