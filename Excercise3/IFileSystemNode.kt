package Excersise4;

interface IFileSystemNode {

    fun GetParent(): IFileSystemNode?;

    fun GetName(): String;

    fun GetPath(): String;

    fun ChangeParent(newParent: IFileSystemNode): Unit;
}