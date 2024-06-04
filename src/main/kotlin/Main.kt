import java.io.File

fun main(args: Array<String>) {
    val extensionToChange=args[0]
    val newExtension=args[1]
    val changedFiles= mutableListOf<File>()
    var fileCounter=0

    val workingDirectory=System.getProperty("user.dir")
    val directoryTree=(File(workingDirectory).walkTopDown())
//    val targetFile= File("${ workingDirectory }/dummy.txt")


    for (file in directoryTree)
    {
       val currentExtension=(file.name.substringAfterLast("."))
        if (currentExtension==extensionToChange) {
            file.renameTo(File(file.canonicalPath.substringBeforeLast(".") + "." + newExtension))
            fileCounter++
        }
    }

}