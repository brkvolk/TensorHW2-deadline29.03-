package Excersise4;

public abstract class AbstractFileSystemNode : IFileSystemNode {
    abstract var parent: IFileSystemNode?
    abstract var name: String
    abstract var path: String

    override fun GetParent(): IFileSystemNode? {
        return parent
    }

    open override fun GetName(): String {
        return name;
    }

    override fun GetPath(): String {
        return path;
    }

    override fun ChangeParent(newParent: IFileSystemNode): Unit {
        this.parent = newParent;
        path = newParent.GetPath() + "/" + this.name;
    }

}
