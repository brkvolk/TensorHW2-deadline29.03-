package Excersise4;

import java.util.ArrayList;

public class Folder(name: String, vararg newChildren: IFileSystemNode) : AbstractFileSystemNode() {

    override var name: String
        get() = name
        set(value) {
            name = value
        }
    override var path: String
        get() = path
        set(v) {
            path = "/$name"
        }
    override var parent: IFileSystemNode? = null

    var Children: MutableList<IFileSystemNode>? = null

    init {
        for (newChild in newChildren)
            this.AddChild(newChild)
    }

    fun GetChildren(): MutableList<IFileSystemNode>? = Children

    fun AddChild(newChild: IFileSystemNode) {
        newChild.ChangeParent(this)
        this.Children?.add(newChild)
    }
}
