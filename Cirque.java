import javax.management.loading.PrivateClassLoader;

public class Cirque {


    public void affiche(Podium p1, Podium p2){
        Animaux a_tmp;
        String blank1="     ";
        String blank2="           ";
        String largeur=" **************";
        String longueur=" *            *";
        int mot_len;
        for (int i =  p1.get_max_animaux()-1; i >=0; i--) { 
            if(p1.get_nb_animaux()>i){
                a_tmp=p1.get_Animaux(i);
                //System.out.print(blank1+a_tmp.get_nom()+blank1);
                System.out.printf("%10s",a_tmp.get_nom());
            }
            else{
                System.out.print(blank2);
            }
            if(p2.get_nb_animaux()>i){
                a_tmp=p2.get_Animaux(i);
                System.out.printf("%28s\n",a_tmp.get_nom());
            }
            else{
                System.out.println(blank2);
            }
        }

        System.out.println(largeur+blank2+largeur);

        for (int i = 0; i < 6; i++) {
            if(i==2){
                System.out.println(" *   "+p1.get_couleur()+"    *"+blank2+" *    "+p2.get_couleur()+"    *");
                continue;
            }
            System.out.println(longueur+blank2+longueur);

        }
        System.out.println(largeur+blank2+largeur);
    }
}

