import java.util.Random;
import java.util.Scanner;

public class bn {

    public static void main (String[] args) {

        Scanner sc = new Scanner (System.in);
        Random gerador = new Random ();

        int opcao;
        String campoIA [] [] = new String [5] [5];
        String campo1 [] [] = new String [5] [5];
        String campoIAFake [] [] = new String [5] [5];

        Menu();

        opcao = sc.nextInt();
        
        while ((opcao  < 1) || (opcao > 3)) {
            System.out.println("Opcao invalida, digite novamente:");
            opcao = sc.nextInt();
            }

        if (opcao == 1) {

            GerarCampoIA(campoIA, gerador);

            System.out.println("---------------------------");
            System.out.println("Monte seu campo de batalha:");
            System.out.println("---------------------------");
            System.out.println("");

            MostrarCampo1(campo1);

            System.out.println("");
            
            MontarCampo1(campo1, sc);

            System.out.println("");
            System.out.println("---------------------------");
            System.out.println("Lute por sua sobrevivencia!");
            System.out.println("---------------------------");
            System.out.println("");

            Mecanica(campo1, campoIA, campoIAFake, sc, gerador);

            System.out.println("");
            System.out.println("1 - Voltar ao menu");
            opcao = sc.nextInt();

            while (opcao != 1) {   
                System.out.println("Opcao invalida, digite 1 para voltar ao menu:");
                opcao = sc.nextInt();
                }

            if (opcao == 1 ) {
                main(args);
                }     

            }


        if (opcao == 2) {
            System.out.println("=============================");
            System.out.println("           INSTRUCOES:       ");
            System.out.println("=============================");
            System.out.println("");
            System.out.println("* O campo tem o tamanho 5x5.");
            System.out.println("* Os jogadores tem direito a 1 ataque por vez.");
            System.out.println("* Para posicionar as pecas e necessario digitar a linha e coluna desejada (de 0 a 4) respectivamente.");
            System.out.println("* O jogador possui 3 tipos de pecas para posicionar no campo:");
            System.out.println("  1 Nexus (dano - vida total), 2 inibidores (dano - peca 1, completo 2) e 3 torres (dano 1).");
            System.out.println("* Os inibidores possuem 2 partes que devem ser colocadas lado a lado.");
            System.out.println("* Se o nexus for destruido, automaticamente quem atirou e o vencedor da partida.");
            System.out.println("* Cada jogar comeca com 8 vidas, quem conseguir se manter vivo e o vencedor.");
            System.out.println("");
            System.out.println("OBS: LEMBRE-SE, O ADVERSARIO NAO ATIRA 2 VEZES NO MESMO LUGAR...");
            
            System.out.println("");
            System.out.println("1 - Voltar ao menu");
            opcao = sc.nextInt();

            while (opcao != 1) {   
                System.out.println("Opcao invalida, digite 1 para voltar ao menu:");
                opcao = sc.nextInt();
                }

            if (opcao == 1 ) {
                main(args);
                }     

            }


        if (opcao == 3) {
            System.exit(0);
            }

            
        }


    public static void Menu() {
                
        System.out.println("");
        System.out.println("                                                         ============================================");
        System.out.println("                                                                BEM VINDOS A BATALHA DE SENTINA!");
        System.out.println("                                                         ============================================");
        System.out.println("");

        System.out.println("                                                                          __________                              ");
        System.out.println("                                                                        .~#########%%;~.                          ");
        System.out.println("                                                                       /############%%;`|                         ");
        System.out.println("                                                                      /######/~//~/%%;,;,|                        ");
        System.out.println("                                                                     |#######|    /;;;;.,.|                       ");
        System.out.println("                                                                     |#########||%;;;;;.,.|                       ");
        System.out.println("                                                            XX       |##/~~|####%;;;/~~|;,|       XX              ");
        System.out.println("                                                          XX..X      |#|  o  |##%;/  o  |.|      X..XX            ");
        System.out.println("                                                        XX.....X     |##|____/##%;|____/.,|     X.....XX          ");
        System.out.println("                                                   XXXXX.....XX      |#########/|;;;;;;,, /      XX.....XXXXX     ");
        System.out.println("                                                  X |......XX%,.@      |######/%;|;;;;, /      @#%,XX......| X    ");
        System.out.println("                                                  X |.....X  @#%,.@     |######%%;;;;,.|     @#%,.@  X.....| X    ");
        System.out.println("                                                  X  |...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X    ");
        System.out.println("                                                   X# |.X        @#%,.@                  @#%,.@        X./  #     ");
        System.out.println("                                                    ##  X          @#%,.@              @#%,.@          X   #      ");
        System.out.println("                                                  , ''# #X            @#%,.@          @#%,.@            X ##      ");
        System.out.println("                                                     `###X             @#%,.@      @#%,.@             ####'       ");
        System.out.println("                                                    . ' ###              @#%.,@  @#%,.@              ###`'        ");
        System.out.println("                                                      . '';''                @#%.@#%,.@                ;'` ' .    ");
        System.out.println("                                                        '                    @#%,.@                   ,.          ");
        System.out.println("                                                        ` ,                @#%,.@  @@                `            ");
        System.out.println("                                                                            @@@  @@@                              ");

        System.out.println("");
        System.out.println("");
        System.out.println("                                                         ============================================");
        System.out.println("                                                         Digite o numero respectivo a opcao desejada:");
        System.out.println("                                                         ============================================");
        System.out.println("");
        System.out.println("                                                                           1- Jogar");
        System.out.println("                                                                           2- Instrucoes");
        System.out.println("                                                                           3- Sair");
        System.out.println("                                                         --------------------------------------------");

        }
    
    public static void MostrarCampo1(String campo1 [] []) {

        int c,i;
        System.out.println("           Seu campo:");
        System.out.println("");
        System.out.println("   0      1      2      3      4");
        for (c=0; c <= campo1.length-1; c++) {
            for (i=0; i <= campo1.length-1; i++) {
                System.out.print("| " + campo1 [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }

    public static void MostrarCampoIA(String campoIA [] []) {

        int c,i;

        System.out.println("        Campo Inimigo:");
        System.out.println("");
        System.out.println("   0      1      2      3      4");
        for (c=0; c <= campoIA.length-1; c++) {
            for (i=0; i <= campoIA.length-1; i++) {
                System.out.print("| " + campoIA [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }

    public static void MostrarCampoIAFake(String campoIAFake [] []) {

        int c,i;
    
        System.out.println("        Campo Inimigo:");
        System.out.println("");
        System.out.println("   0      1      2      3      4");
        for (c=0; c <= campoIAFake.length-1; c++) {
            for (i=0; i <= campoIAFake.length-1; i++) {
                System.out.print("| " + campoIAFake [c] [i] + " ");
                }
            System.out.println("| " + c);
            }
        }




    
    public static void GerarCampoIA(String campoIA[] [], Random gerador) {

        int nrandom1, nrandom2, escolhaverif, verifcima, verifbaixo, verifdireita, verifesquerda;
        int qnexus=0, qinibidor=0, qtorre=0;

        while (qnexus < 1) {
            nrandom1 = gerador.nextInt(campoIA.length);
            nrandom2 = gerador.nextInt(campoIA.length);
            if (campoIA [nrandom1] [nrandom2] == null) {
                campoIA [nrandom1] [nrandom2] = "nexus";  
                qnexus = qnexus + 1;
                }
            }
        while (qinibidor < 2) {
            nrandom1 = gerador.nextInt(campoIA.length);
            nrandom2 = gerador.nextInt(campoIA.length);
            verifcima = nrandom1 - 1;
            verifbaixo = nrandom1 + 1;
            verifdireita = nrandom2 + 1;
            verifesquerda = nrandom2 -1;
            escolhaverif = gerador.nextInt(4);

            if (campoIA [nrandom1] [nrandom2] == null) {
                if (escolhaverif == 0) {
                    if ((verifcima < campoIA.length) && (verifcima >= 0) && (campoIA [verifcima] [nrandom2] == null)) {
                        
                        if (qinibidor == 0) {
                            campoIA [nrandom1] [nrandom2] = "inib1";
                            campoIA [verifcima] [nrandom2] = "inib2";
                            } else {
                                campoIA [nrandom1] [nrandom2] = "inib3"; 
                                campoIA [verifcima] [nrandom2] = "inib4";
                                }

                        qinibidor = qinibidor + 1;
                        }
                    }
                if (escolhaverif == 1) {
                    if ((verifbaixo < campoIA.length) && (verifbaixo >= 0) && (campoIA [verifbaixo] [nrandom2] == null)) {
            
                        if (qinibidor == 0) {
                            campoIA [nrandom1] [nrandom2] = "inib1";
                            campoIA [verifbaixo] [nrandom2] = "inib2";
                            } else {
                                campoIA [nrandom1] [nrandom2] = "inib3"; 
                                campoIA [verifbaixo] [nrandom2] = "inib4";
                                }

                        qinibidor = qinibidor + 1;
                        }
                    }
                if (escolhaverif == 2) {
                    if ((verifdireita < campoIA.length) && (verifdireita >= 0) && (campoIA [nrandom1] [verifdireita] == null)) {
         
                        if (qinibidor == 0) {
                            campoIA [nrandom1] [nrandom2] = "inib1";
                            campoIA [nrandom1] [verifdireita] = "inib2";
                            } else {
                                campoIA [nrandom1] [nrandom2] = "inib3"; 
                                campoIA [nrandom1] [verifdireita] = "inib4";
                                }

                        qinibidor = qinibidor + 1;
                        }
                    }
                if (escolhaverif == 3) {
                    if ((verifesquerda < campoIA.length) && (verifesquerda >= 0) && (campoIA [nrandom1] [verifesquerda] == null)) {

                        if (qinibidor == 0) {
                            campoIA [nrandom1] [nrandom2] = "inib1";
                            campoIA [nrandom1] [verifesquerda] = "inib2";
                            } else {
                                campoIA [nrandom1] [nrandom2] = "inib3"; 
                                campoIA [nrandom1] [verifesquerda] = "inib4";
                                }

                        qinibidor = qinibidor + 1;
                        }
                    }
                }
            }

        while (qtorre < 3) {
            nrandom1 = gerador.nextInt(campoIA.length);
            nrandom2 = gerador.nextInt(campoIA.length);
            if (campoIA [nrandom1] [nrandom2] == null) {
                campoIA [nrandom1] [nrandom2] = "torre";  
                qtorre = qtorre + 1;
                }
            }
        }

    public static void MontarCampo1 (String campo1[] [], Scanner sc) {
    
        int auxposicao1=0, auxposicao2=0, posicaoinib1, posicaoinib2;
        int torre=0, inibidor=0, c=1, i=1;

        System.out.println("Escolha a posicao do nexus:");
        auxposicao1 = sc.nextInt(); 
        auxposicao2 = sc.nextInt();

   
        while ((auxposicao1 >= campo1.length) || (auxposicao1 < 0) || ((auxposicao2 >= campo1.length) || (auxposicao2 < 0))) {
            System.out.println("Digite um espaco valido do campo de 0 a 4:");
            auxposicao1 = sc.nextInt(); 
            auxposicao2 = sc.nextInt();
            }

        campo1 [auxposicao1] [auxposicao2] = "nexus";
        System.out.println("");
        MostrarCampo1(campo1);
        System.out.print("");

        while (inibidor < 2) {
            System.out.println("");
            System.out.println("Escolha a posicao do inibidor " + c + ":");

            if (inibidor == 0) {
                System.out.println("inib1:");
                } else {
                    System.out.println("inib3:");
                    }

            auxposicao1 = sc.nextInt(); 
            auxposicao2 = sc.nextInt();

            while ((auxposicao1 >= campo1.length) || (auxposicao1 < 0) || ((auxposicao2 >= campo1.length) || (auxposicao2 < 0)) || (campo1[auxposicao1] [auxposicao2] != null)) {
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:" );
                auxposicao1 = sc.nextInt(); 
                auxposicao2 = sc.nextInt();
                }
            if (inibidor == 0) {
                campo1 [auxposicao1] [auxposicao2] = "inib1";
                } else {
                    campo1 [auxposicao1] [auxposicao2] = "inib3";
                    }
            posicaoinib1 = auxposicao1;
            posicaoinib2 = auxposicao2;
            System.out.println("");
            MostrarCampo1(campo1);
            System.out.print("");

            System.out.println("");
            if (inibidor == 0) {
                System.out.println("inib2:");
                } else {
                    System.out.println("inib4:");
                    }

            auxposicao1 = sc.nextInt(); 
            auxposicao2 = sc.nextInt();

            while (((auxposicao1 >= campo1.length) || (auxposicao1 < 0)) || ((auxposicao2 >= campo1.length) || (auxposicao2 < 0)) || ((campo1[auxposicao1] [auxposicao2] != null)) || ((auxposicao2 != posicaoinib2) && (auxposicao1 != posicaoinib1)) || ((auxposicao1 != posicaoinib1+1) && (auxposicao1 != posicaoinib1-1) && (auxposicao2 != posicaoinib2+1) && (auxposicao2 != posicaoinib2-1))) {
                System.out.println("Lembre-se, pecas com uma o mais partes devem ser colocadas lado a lado." );
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:" );
                auxposicao1 = sc.nextInt(); 
                auxposicao2 = sc.nextInt();
                }

            if (inibidor == 0) {
                campo1 [auxposicao1] [auxposicao2] = "inib2";
                } else {
                    campo1 [auxposicao1] [auxposicao2] = "inib4";
                    }
            System.out.println("");
            MostrarCampo1(campo1);
            System.out.print(""); 
            inibidor = inibidor + 1;
            c = c + 1;
            }    
        
        while (torre < 3) {
            System.out.println("");
            System.out.println("Escolha a posicao da torre " + i + ":");
            auxposicao1 = sc.nextInt(); 
            auxposicao2 = sc.nextInt();

            while ((auxposicao1 >= campo1.length) || (auxposicao1 < 0) || ((auxposicao2 >= campo1.length) || (auxposicao2 < 0)) || (campo1[auxposicao1] [auxposicao2] != null)) {
                System.out.println("Espaco fora do campo ou ja esta preenchido, digite novamente:" );
                auxposicao1 = sc.nextInt(); 
                auxposicao2 = sc.nextInt();
                }
            campo1 [auxposicao1] [auxposicao2] = "torre";
            System.out.println("");
            MostrarCampo1(campo1);
            System.out.print(""); 
            i++;
            torre++;
            }

        }
    
    public static void Mecanica(String campo1 [] [], String campoIA[] [], String campoIAFake [] [], Scanner sc, Random gerador) {

        int vida1=8, vidaIA=8, jogadaIA1, jogadaIA2, jogada1J, jogada2J;
        int vidaInib1=2, vidaInib2=2, vidaInibIA1=2, vidaInibIA2=2;

        while ((vida1 > 0) && (vidaIA > 0)) {
            System.out.println("");
            MostrarCampo1(campo1);
            System.out.println("");
            System.out.println("======================");
            System.out.println("Seus pontos de vida: " + vida1);
            System.out.println("======================");
            System.out.println("");
            MostrarCampoIAFake(campoIAFake);
            System.out.println("");
            System.out.println("=======================");
            System.out.println("Pontos de vida da IA: " + vidaIA);
            System.out.println("=======================");
            System.out.println("");
            System.out.println("---------------");
            System.out.println("Jogador ataque!");
            System.out.println("---------------");
            System.out.println("");       

            jogada1J = sc.nextInt();
            jogada2J = sc.nextInt();
            System.out.println("");

            while ((jogada1J >= campo1.length) || (jogada1J < 0) || ((jogada2J >= campo1.length) || (jogada2J < 0)) || (campoIAFake [jogada1J] [jogada2J] != null && campoIAFake [jogada1J] [jogada2J].equals("  x "))) {
                System.out.println("Estrutura ja destruida ou espaco fora do campo, digite um numero de 0 a 4:");
                jogada1J = sc.nextInt(); 
                jogada2J = sc.nextInt();
                }

            if (campoIA [jogada1J] [jogada2J] == "nexus") {
                System.out.println("==============================");
                System.out.println("Vitoria!");
                System.out.println("Voce destruiu o nexus inimigo.");
                System.out.println("==============================");
                System.out.println("");
                campoIAFake [jogada1J] [jogada2J] = "nexus";
                vidaIA = 0;

                }else if (campoIA [jogada1J] [jogada2J] != null) {

                    if ((vidaInibIA1 == 1) && ((campoIA [jogada1J] [jogada2J].equals("inib1")) || (campoIA [jogada1J] [jogada2J].equals("inib2")))) {
                        System.out.println("==========================");
                        System.out.println("Voce destruiu um inibidor!");
                        System.out.println("==========================");
                        System.out.println("");
                        campoIAFake [jogada1J] [jogada2J] = "  x ";
                        vidaIA = vidaIA - 2;
                        vidaInibIA1 = vidaInibIA1 - 1;

                        }else if ((vidaInibIA2 == 1) && ((campoIA [jogada1J] [jogada2J].equals("inib3")) || (campoIA [jogada1J] [jogada2J].equals("inib4")))) {
                            System.out.println("==========================");
                            System.out.println("Voce destruiu um inibidor!");
                            System.out.println("==========================");
                            System.out.println("");
                            campoIAFake [jogada1J] [jogada2J] = "  x ";
                            vidaIA = vidaIA - 2;
                            vidaInibIA2 = vidaInibIA2 - 1;

                            }else if ((campoIA [jogada1J] [jogada2J].equals("inib1")) || (campoIA [jogada1J] [jogada2J].equals("inib2"))) {
                                System.out.println("====================================");
                                System.out.println("Voce destruiu metade de um inibidor!");
                                System.out.println("====================================");
                                System.out.println("");
                                campoIAFake [jogada1J] [jogada2J] = "  x ";
                                vidaIA = vidaIA - 1;
                                vidaInibIA1 = vidaInibIA1 - 1;

                                }else if ((campoIA [jogada1J] [jogada2J].equals("inib3")) || (campoIA [jogada1J] [jogada2J].equals("inib4"))) {
                                    System.out.println("====================================");
                                    System.out.println("Voce destruiu metade de um inibidor!");
                                    System.out.println("====================================");
                                    System.out.println("");
                                    campoIAFake [jogada1J] [jogada2J] = "  x ";
                                    vidaIA = vidaIA - 1;
                                    vidaInibIA2 = vidaInibIA2 - 1;

                                    }else {
                                        System.out.println("========================");
                                        System.out.println("Voce destruiu uma torre!");
                                        System.out.println("========================");
                                        System.out.println("");
                                        campoIAFake [jogada1J] [jogada2J] = "  x ";
                                        vidaIA = vidaIA - 1;
                                        }  

                    }else {
                        System.out.println("===============");
                        System.out.println("Tiro na agua :/");
                        System.out.println("===============");
                        System.out.println("");
                        campoIAFake [jogada1J] [jogada2J] = "  ~ ";
                        }


            if (vidaIA > 0 && (vida1 > 0)) {
                System.out.println("------------");
                System.out.println("Minha vez...");
                System.out.println("------------");
                System.out.println("");
                jogadaIA1 = gerador.nextInt(campo1.length);
                jogadaIA2 = gerador.nextInt(campo1.length);

                while (campo1 [jogadaIA1] [jogadaIA2] != null && campo1 [jogadaIA1] [jogadaIA2].equals("  x ") || (campo1 [jogadaIA1] [jogadaIA2] != null && campo1 [jogadaIA1] [jogadaIA2].equals("  ~ "))) {
                    jogadaIA1 = gerador.nextInt(campo1.length);
                    jogadaIA2 = gerador.nextInt(campo1.length);
                    }

                System.out.println(jogadaIA1 + " " + jogadaIA2);
                System.out.println("");

                if (campo1 [jogadaIA1] [jogadaIA2] == "nexus") {
                    System.out.println("======================================");
                    System.out.println("- Nossa, eu venci!? voce e ruim mesmo!");
                    System.out.println("A IA destruiu seu nexus.");
                    System.out.println("======================================");
                    System.out.println("");
                    vida1 = 0;
                
                    }else if (campo1 [jogadaIA1] [jogadaIA2] != null) {

                        if ((vidaInib1 == 1) && ((campo1 [jogadaIA1] [jogadaIA2].equals("inib1")) || (campo1 [jogadaIA1] [jogadaIA2].equals("inib2")))) {
                            System.out.println("============================");
                            System.out.println("Destrui um inibidor! Haha xD");
                            System.out.println("============================");
                            System.out.println("");
                            campo1 [jogadaIA1] [jogadaIA2] = "  x ";
                            vida1 = vida1 - 2;
                            vidaInib1 = vidaInib1 - 1;

                            }else if ((vidaInib2 == 1) && ((campo1 [jogadaIA1] [jogadaIA2].equals("inib3")) || (campo1 [jogadaIA1] [jogadaIA2].equals("inib4")))) {
                                System.out.println("============================");
                                System.out.println("Destrui um inibidor! Haha xD");
                                System.out.println("============================");
                                System.out.println("");
                                campo1 [jogadaIA1] [jogadaIA2] = "  x ";
                                vida1 = vida1 - 2;
                                vidaInib2 = vidaInib2 - 1;

                                }else if ((campo1 [jogadaIA1] [jogadaIA2].equals("inib1")) || (campo1 [jogadaIA1] [jogadaIA2].equals("inib2"))) {
                                    System.out.println("========================================");
                                    System.out.println("Acabo de destruir metade de um inibidor!");
                                    System.out.println("========================================");
                                    System.out.println("");
                                    campo1 [jogadaIA1] [jogadaIA2] = "  x ";
                                    vida1 = vida1 - 1;
                                    vidaInib1 = vidaInib1 - 1;

                                    }else if ((campo1 [jogadaIA1] [jogadaIA2].equals("inib3")) || (campo1 [jogadaIA1] [jogadaIA2].equals("inib4"))) {
                                        System.out.println("========================================");
                                        System.out.println("Acabo de destruir metade de um inibidor!");
                                        System.out.println("========================================");
                                        System.out.println("");
                                        campo1 [jogadaIA1] [jogadaIA2] = "  x ";
                                        vida1 = vida1 - 1;
                                        vidaInib2 = vidaInib2 - 1;

                                        }else {
                                            System.out.println("================");
                                            System.out.println("Cade sua torre!?");
                                            System.out.println("================");
                                            System.out.println("");
                                            campo1 [jogadaIA1] [jogadaIA2] = "  x ";
                                            vida1 = vida1 - 1;
                                            }  
                        } else {
                            System.out.println("=====================================");
                            System.out.println("- Na agua... eu nao sirvo pra isso :/");
                            System.out.println("=====================================");
                            System.out.println("");
                            campo1 [jogadaIA1] [jogadaIA2] = "  ~ ";
                            }
                }
            
            }

        if (vida1 <= 0) {
            vida1 = 0;
            } else {
                vidaIA = 0;
                }

        MostrarCampo1(campo1);
        System.out.println("");
        System.out.println("======================");
        System.out.println("Seus pontos de vida: " + vida1);
        System.out.println("======================");
        System.out.println("");
        MostrarCampoIAFake(campoIAFake);
        System.out.println("");
        System.out.println("=======================");
        System.out.println("Pontos de vida da IA: " + vidaIA);
        System.out.println("=======================");

        if (vida1 > 0) {
            System.out.println("");
            System.out.println("===========================");
            System.out.println("O jogador vence a partida.");
            System.out.println("===========================");
            } else {
                System.out.println("");
                System.out.println("======================");
                System.out.println("A IA vence a partida.");
                System.out.println("======================");
                }  

        }


    }