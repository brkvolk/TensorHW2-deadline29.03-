package Excersise4;

class File(_name: String, exstention: String) : AbstractFileSystemNode() {
    override var name: String = _name
    var Extension: String = exstention
    override var parent: IFileSystemNode? = null
        set(value) {
            parent = value
            path = parent?.GetPath() ?: "/"
        }
    override var path: String = parent?.GetPath() ?: "/"
        set(value) {
            parent?.GetPath() ?: "/"
        }

    fun GetExtensin() = Extension

    fun GetFilePath(): String = this.path

}
