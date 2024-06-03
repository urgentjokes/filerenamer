import java.io.File

class FileRenamer (val fileToRename: File, val newExtension:String) {
    fun renameIt() {
        fileToRename.renameTo(File(fileToRename.name.replaceAfterLast(".",newExtension)))
    }
}