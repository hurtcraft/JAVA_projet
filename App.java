import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static void main(String argv[]){
        Liste_Joueurs liste_joueurs=new Liste_Joueurs();
        Cirque cirque=new Cirque();
        Carte liste_carte;
        Podium p_rouge=new Podium("Rouge");
        Podium p_bleu=new Podium("Bleu");
        Animaux liste_Animaux[] = new Animaux[p_rouge.get_max_animaux()];
        add_animaux_to_list(liste_Animaux);
        generate_carte(liste_Animaux,p_rouge,p_bleu);
        final int LION=0;
        final int OURS=1;
        final int ELEPHANT=2;

        //saisie_joueur(liste_joueurs);




        //cirque.affiche(p_rouge,p_bleu);
        
    }
    public static void add_animaux_to_list(Animaux liste_Animaux[]){


        String noms_animaux[]=new String[liste_Animaux.length];
        noms_animaux[0]="lion";
        noms_animaux[1]="ours";
        noms_animaux[2]="elephant";
        normalise_nom_animaux(noms_animaux);

        Animaux a_tmp;
        
        for (int i = 0; i < noms_animaux.length; i++) {
            a_tmp= new Animaux(noms_animaux[i]);
            liste_Animaux[i]=a_tmp;
        }

        
    }
    public static void normalise_nom_animaux(String noms_animaux[]){
        assert noms_animaux.length==0;
        int max_len=-1;
        int name_len;
        for (int i = 0; i < noms_animaux.length; i++) {
            name_len=noms_animaux[i].length();
            if(name_len>max_len){
                max_len=name_len;
            }
        }
        int nb_blank;
        StringBuilder sb;
        
        for (int i = 0; i < noms_animaux.length; i++) {
            sb=new StringBuilder();
            name_len=noms_animaux[i].length();

            nb_blank=max_len-name_len;
            nb_blank=nb_blank/2;
            for (int j = 0; j < nb_blank; j++) {
                sb.append(" ");
            }
            sb.append(noms_animaux[i]);
            for (int k = 0; k < nb_blank; k++) {
                sb.append(" ");
            }
            noms_animaux[i]=sb.toString();
            
        }

    }
    public static void saisie_joueur(Liste_Joueurs liste_joueurs){
        Joueur j_tmp;
        System.out.println("Saisie des joueurs [Y] pour finir la saisie : ");
        Scanner sc=new Scanner(System.in);
        String j_nom;
        int i =1;
        while(true){
            System.out.println("saisir un nom pour le joueur "+i+" : ");
            j_nom=sc.nextLine();
            if(j_nom.equals("Y") || j_nom.equals("y")){
                break; // condition de fin de boucle , j'ai pas trouvé plus propre pour l'instant :/
            }
            if(liste_joueurs.joueur_exist(j_nom)){
                
                System.out.println("Le joueur existe deja :/");
                continue;
            }
            j_tmp=new Joueur(j_nom);
            liste_joueurs.add(j_tmp);
            System.out.println("Joueur "+ j_nom+" ajouté avec succès ! \n");
            i++;
        };

        sc.close();        

    }
    
    
    public static ArrayList<Carte> generate_carte(Animaux liste_Animaux[],Podium p1, Podium p2){
        assert liste_Animaux.length==0;
        //Carte liste_carte[]=new Carte[24];
        int nb_animaux=liste_Animaux.length;
        Carte carte_tmp;
        Carte carte_tmp2;
        ArrayList <Carte> liste_carte= new ArrayList<>();

        //System.out.println(nb_animaux);
        for (int i = 0; i <nb_animaux; i++) {
            p1.push(liste_Animaux[i]);
        }
        for (int i = 0; i < nb_animaux; i++) {
            carte_tmp=new Carte(p1, p2);
    
            System.out.println(carte_tmp);

            p1.last_to_top();
            liste_carte.add(carte_tmp);
            count++;

        }
        return liste_carte;
    }


}