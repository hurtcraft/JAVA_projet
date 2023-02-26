import java.util.ArrayList;

class Joueur {
    private String nom; //
    private int score;
    private boolean token;
    public Joueur(String nom){
        this.nom=nom;
        this.score=0;
        this.token=true;
    }
    public void increase_score(){
        this.score++;
    }
    public String get_nom(){
        return this.nom;
    }
    public boolean peu_jouer(){
        return token;
    }
    public void set_token(boolean b){
        this.token=b;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("nom : ");
        sb.append(this.nom);
        sb.append(" | ");
        sb.append("Score : ");
        sb.append(this.score);
        sb.append("\n");
        return sb.toString();
    }
}

public class Liste_Joueurs{
    private ArrayList<Joueur> liste_joueurs;
    public Liste_Joueurs(){
        liste_joueurs=new ArrayList<>();
    }
    public boolean add(Joueur J){
        if(joueur_exist(J.get_nom())){
            return false;
        }
        this.liste_joueurs.add(J);
        return true;
    }
    public Joueur get_joueur_by_name(String nom_joueur){
        assert joueur_exist(nom_joueur);

        Joueur j_tmp=new Joueur(nom_joueur);
        
        for (int i = 0; i < this.liste_joueurs.size(); i++){
            j_tmp=this.liste_joueurs.get(i);
            if(j_tmp.get_nom().equals(nom_joueur)){
                break;
            }
        }
        return j_tmp;


    }
    public boolean joueur_exist(String nom_joueur){
        Joueur j_tmp;
        for (int i = 0; i < this.liste_joueurs.size(); i++){
            j_tmp=this.liste_joueurs.get(i);
            if(j_tmp.get_nom().equals(nom_joueur)){
                return true;
            }
        }
        return false;
    }
    public int size(){
        return this.liste_joueurs.size();
    }
    public String toString() {
        // TODO Auto-generated method stub
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < this.liste_joueurs.size(); i++) {
            sb.append(this.liste_joueurs.get(i));
            sb.append("------------------------------------------\n");
        }
        return sb.toString();
    }
}