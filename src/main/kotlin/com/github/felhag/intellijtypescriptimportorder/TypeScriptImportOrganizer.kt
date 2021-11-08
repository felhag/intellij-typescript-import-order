package com.github.felhag.intellijtypescriptimportorder

import com.intellij.lang.javascript.DialectDetector.isTypeScript
import com.intellij.lang.javascript.imports.FlowImportOptimizer
import com.intellij.lang.javascript.imports.JSModuleImportOptimizerBase
import com.intellij.lang.javascript.psi.JSFile
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import org.apache.commons.lang.StringUtils
import java.util.stream.Collectors

class TypeScriptImportOrganizer : JSModuleImportOptimizerBase() {
    private val log = Logger.getInstance(TypeScriptImportOrganizer::class.java)
    private val groups = listOf(
        Regex("import(.*)from ?[\"'].*"),
        Regex("import(.*)from ?[\"']@ap.*"),
        Regex("import(.*)from ?[\"']\\..*"),
    )

    override fun supports(file: PsiFile): Boolean {
        return file is JSFile && isTypeScript(file)
    }

    override fun getModulesInfo(p0: PsiElement): MutableCollection<UnusedModuleInfo> {
        val moduleInfo = FlowImportOptimizer().getModulesInfo(p0)
        val result: ArrayList<UnusedModuleInfo> = ArrayList()
        result.addAll(moduleInfo)

        for (info in moduleInfo) {
            log.debug("sorting " + info.importTexts.size + " imports")
            val imports = info.importTexts
                .stream()
                .filter { i -> StringUtils.startsWith(i, "import") }
                .collect(Collectors.groupingBy { i -> groups.indexOfLast { regex -> regex.matches(i) } })

            info.importTexts.clear()
            imports.entries.sortedBy { it.key }
            imports.values.forEach { e ->
                run {
                    info.importTexts.add("\n")
                    info.importTexts.add("\n")
                    info.importTexts.addAll(e)
                }
            }
            log.debug("sorted " + info.importTexts.size + " imports, created " + imports.size + " groups")
        }

        return result
    }
}
