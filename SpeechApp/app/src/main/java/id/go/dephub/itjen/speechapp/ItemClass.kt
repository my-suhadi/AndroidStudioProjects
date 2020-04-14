package id.go.dephub.itjen.speechapp

class ItemClass(_imageResource: Int, _name: String) {
    // define the property of ItemClass class
    // internal bisa diakses oleh instan (dlm 1 modul) dan turunan
    internal val imageResource = _imageResource
    internal val name = _name
}