import java.util.ArrayList;
import java.lang.StringBuilder;

class Animaux{
    private String nom;
    public Animaux(String nom){
        this.nom=nom;
    }
    public String get_nom(){
        return this.nom;
    }
}

public class Podium {
    private String couleur;
    private Animaux animal_stack[];
    private int nb_animaux;
    private static final int MAX_ANIMAUX=3;

    public Podium(){
        this.couleur=" ";
        this.animal_stack=new Animaux[this.MAX_ANIMAUX];
        this.nb_animaux=0;
    }
    public int get_max_animaux(){
        return Podium.MAX_ANIMAUX;
    }
    public Podium(String couleur ){
        this();
        this.couleur=couleur; 
    }
    
    public void push(Animaux a){
        assert this.est_pleine();
        this.animal_stack[this.nb_animaux]=a;
        this.nb_animaux++;
    }

    public Animaux pop(){
        assert this.est_vide();
        Animaux a_tmp;
        a_tmp=this.animal_stack[this.nb_animaux-1];
        this.nb_animaux--;

        return a_tmp;
    }
    public boolean est_vide(){
        return this.nb_animaux==0;
    }
    public boolean est_pleine(){
        return this.nb_animaux>this.MAX_ANIMAUX;
    }
    public void last_to_top(){
        // INSTRUCTION NI MA
        assert this.est_vide();

        Podium podium_tmp=new Podium();
        Animaux animaux_tmp;
        for (int i = this.nb_animaux-1; i >=0 ; i--) {
            podium_tmp.push(this.pop());
        }
        animaux_tmp=podium_tmp.pop();
        for (int i = podium_tmp.nb_animaux-1; i >=0; i--) {
            this.push(podium_tmp.pop());
        }
        this.push(animaux_tmp);
        
    }
    public void jump_to(Podium P){
        // INSTRUCTION KI LO
        assert this.est_vide();
        assert P.est_pleine();

        P.push(this.pop());
    }
    public void permut_top(Podium P){
        // INSTRUCTION SO
        assert (!P.est_vide() && !this.est_vide());
        Animaux animal_tmp=this.pop();
        this.push(P.pop());
        P.push(animal_tmp);

    }
    public Animaux get_Animaux(int index){
        assert index<=this.nb_animaux && index>=0;
        return this.animal_stack[index];
    }
    public int get_nb_animaux(){
        return this.nb_animaux;
    }
    public String get_couleur(){
        return this.couleur;
    }
    public Podium clone(){
        Podium p_tmp=new Podium(this.couleur);
        p_tmp.nb_animaux=this.nb_animaux;
        p_tmp.animal_stack=this.animal_stack.clone();

        return p_tmp;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for (int i = this.nb_animaux-1; i >=0 ; i--) {
            sb.append(this.animal_stack[i].get_nom());
            sb.append("\n");   
        }
        sb.append("--------\n");
        sb.append(this.couleur);
        return sb.toString();
    }

}