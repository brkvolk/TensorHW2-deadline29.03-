package Excersise4;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println

public class Program {
    fun main() {

        var root = Folder("root")
        var file1 = File("file1", "txt")
        // System.out.println( file1.GetName() )
        var firstFolder = Folder("firstFolder", file1)
        var file2 = File("file2", "java")
        var secondFolder = Folder("secondFolder", file1, file2)
        root.AddChild(firstFolder)
        root.AddChild(secondFolder)
        for (f in root.GetChildren()!!)
            println("root chlild:\t${f.GetName()} \n")
        var folder = root.Children!![1] as Folder
        for (f in folder.GetChildren()!!)
            println(f.GetName())
    }
}
