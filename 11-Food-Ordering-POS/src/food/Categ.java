
package food;

public class Categ {
     private int CategorieId=1;
    private String CategorieName;

    public Categ(int CategorieId, String CategorieName) {
        this.CategorieId = CategorieId;
        this.CategorieName = CategorieName;
    }

   

   
    public Categ() {
    }

    Categ(String category_1) {
                this.CategorieName = category_1;

    }

    public int getCategorieId() {
        return CategorieId;
    }

    public void setCategorieId(
            int CategorieId) {
        this.CategorieId = CategorieId;
    }

    public String getCategorieName() {
        return CategorieName;
    }

    public void setCategorieName(
            String CategorieName) {
        this.CategorieName = CategorieName;
    }
    
}
