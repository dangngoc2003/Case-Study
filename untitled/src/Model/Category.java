package Model;

public class Category {
    static int  Index=1;
    int id;
    String name;

    public Category() {
    }

    public Category( String name) {
        this.id = Index;
        this.name = name;
        Index++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public void disPlay(){
        System.out.printf("%-15s%s",id,name+"\n");
    }
}
