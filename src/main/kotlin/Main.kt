import java.io.File

fun main(args: Array<String>) {
    val extensionToChange=args[0]
    val newExtension=args[1]
    val changedFiles= mutableListOf<File>()

    println(extensionToChange)
    println(newExtension)

    val workingDirectory=System.getProperty("user.dir")
    val directoryTree=(File(workingDirectory).walkTopDown())
//    val targetFile= File("${ workingDirectory }/dummy.txt")


    for (file in directoryTree)
    {
       val currentExtension=(file.name.substringAfterLast("."))
        if (currentExtension==extensionToChange) {
            file.renameTo((File(file.canonicalPath.substringBeforeLast(".") + "." + newExtension)))
            changedFiles.add((File(file.canonicalPath.substringBeforeLast(".") + "." + newExtension)))
        }
    }

    for (file in changedFiles) {
        file.copyTo(File(workingDirectory+"/Storage/"+file.name))
    }




}