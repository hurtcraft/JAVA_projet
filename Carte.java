public class Carte {
    // une carte est un couple de podium
    private Podium p1;
    private Podium p2;
    public Carte(Podium p1,Podium p2){
        this.p1=p1;
        this.p2=p2;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String largeur= "-------------------------------------\n";
        sb.append(largeur);
        Animaux a_tmp;
        String trait_debut=String.format("%-5s", "|");
        String trait_milieu=String.format("%5s %5s", "|"," ");
        String blank = "        ";
        for (int i = p1.get_max_animaux(); i >=0; i--) {
            sb.append(trait_debut);

            if(p1.get_nb_animaux()>i){
                a_tmp=p1.get_Animaux(i);
                sb.append(a_tmp.get_nom());                
            }
            else{
                sb.append(blank);
            }
            sb.append(trait_milieu);
            if(p2.get_nb_animaux()>i){
                a_tmp=p2.get_Animaux(i);
                sb.append(a_tmp.get_nom());
                
            }
            else{
                sb.append(blank);
            }
            sb.append(trait_milieu);
            sb.append("\n");

        }

        sb.append(largeur);
        sb.append(String.format("%10s %8s", p1.get_couleur()," "));
        sb.append(String.format("%10s", p2.get_couleur()));
        return sb.toString();
    }
}

