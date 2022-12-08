import java.security.SecureRandom;

public class Drawing {
    SecureRandom secureRandom = new SecureRandom();
    int n;
    int orbs = 0;
    int urnsWithMinTwoOrbs = 0;
    int urnsWithMinOneOrb = 0;
    int[] urny;
    int Bn = 0;
    int Un = 0;
    int Ln = 0;
    int Cn = 0;
    int Dn = 0;
    int[] results = new int[6];

    public Drawing(int n) {
        this.n=n;
        urny = new int[n];
        for (int i = 0; i < n; i++) {
            urny[i] = 0;
        }
    }
    public int[] addOrbs() {
        while(urnsWithMinTwoOrbs != n) {
            int random = secureRandom.nextInt(n);
            urny[random] += 1;
            if (urny[random] == 1) {
                urnsWithMinOneOrb++;
            }
            if(urny[random] == 2) {
                urnsWithMinTwoOrbs++;
            }
            orbs++;
            if (orbs == n) {
                //Un & Ln
                //Calculating Un
                int counter = 0;
                for(int i = 0; i < n; i++) {
                    if(urny[i] == 0) {
                        counter++;
                    }
                }
                Un = counter;
                //Calculating Ln
                int max = urny[0];
                for(int i = 1; i < n; i++) {
                    if (urny[i] > max) {
                        max = urny[i];
                    }
                }
                Ln = max;
            }
            //Bn & Cn
            //Calculating Bn
            if(Bn == 0 && urnsWithMinTwoOrbs == 1) {
                Bn = orbs;
            }
            //Calculating Cn
            if(Cn == 0 && urnsWithMinOneOrb == n) {
                Cn = orbs;
            }
        }
        //Calculating Dn
        Dn = orbs;

        //Getting Bn
        results[0] = Bn;
        //Getting Un
        results[1] = Un;
        //Getting Ln
        results[2] = Ln;
        //Getting Cn
        results[3] = Cn;
        //Getting Dn
        results[4] = Dn;
        //Getting Dn - Cn
        results[5] = Dn - Cn;

        return results;
    }
}
