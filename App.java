import java.net.PortUnreachableException;
import java.util.Scanner;

public class App{
    public static void main(String argv[]){
        Liste_Joueurs liste_joueurs=new Liste_Joueurs();
        Cirque cirque=new Cirque();
        Carte liste_carte;
        //saisie_joueur(liste_joueurs);
        Podium p_rouge=new Podium("Rouge");
        Podium p_bleu=new Podium("Bleu");

        
        Animaux lion= new Animaux("lion");
        Animaux elephant= new Animaux("elephant");
        Animaux ours= new Animaux("ours");
        

        p_rouge.push(lion);
        p_rouge.push(ours);
        p_bleu.push(elephant);
        p_rouge.jump_to(p_bleu);
        cirque.affiche(p_rouge,p_bleu);
        
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
    public static Carte[] generate_carte(){
        Carte liste_carte[]=new Carte[24];
        int nb_animaux=3;
        Carte carte_tmp;
        Podium p1=new Podium("Rouge");
        Podium p2=new Podium("Bleu");
        Animaux lion= new Animaux("lion");
        Animaux elephant= new Animaux("elephant");
        Animaux ours= new Animaux("ours");
        p1.push(elephant);
        p2
        return liste_carte;
    }


}