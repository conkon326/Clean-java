public class Q4 {
    public static void main(String[] args) {
        int totalCargo = 600;
        int maxCapacity = 5000;

        int currentTruckLoad = 0;
        int truckCount = 0;
        int cargoWeight = totalCargo;
        
        while (cargoWeight > 0) {
            if (currentTruckLoad + cargoWeight <= maxCapacity) {
                currentTruckLoad += cargoWeight;
                cargoWeight--;
            } else {
                currentTruckLoad = 0;
                truckCount++;
            }
        }
        
        if (currentTruckLoad > 0) {
            truckCount++;
        }
        
        System.out.println(truckCount);
    }
}


// 荷物がいっぱいです
// ここに600個の荷物があり、それぞれの重さは1kg、2kg、3kg、……、600kgとなっています。これらを最大積載量5000kgのトラックを何台か使って運ぼうとしています。

// トラックに荷物を載せるのに、次のような方針を立てました。

// 重い荷物から順にトラックに載せていく。
// ある荷物を載せると最大積載量を超えてしまう場合は、新しいトラックを用意してそちらに載せる。古いほうのトラックには以降は新しい荷物は載せない。
// この方針に従うと、

// 1台目のトラックには600kg，599kg，598kg，597kg，596kg，595kg，594kg，593kgの荷物が載せられる。
// 2台目のトラックには592kg，591kg，590kg，589kg，588kg，587kg，586kg，585kgの荷物が載せられる。
// となります。最終的に何台のトラックが必要になるかを求めてください。