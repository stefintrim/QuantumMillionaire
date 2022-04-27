### Who wants to be a ...
# QUANTUM MILLIONAIRE!

Welcome to the only GitHub project that absolutely 100% guarantees* that you* will win* the lottery.

## Watch The Universe Split Before Your Very Eyes!

By using quantum mechanical theory, this web app, based on Scala, Cats Effect and Http4s can generate a set of quantum random numbers that will make a version of you rich, rich, rich!

### But How Does It Work?

In 1957, Hugh Everett III wrote his doctoral dissertation proposing an austere interpretation of quantum mechanics that does not include wave function collapse, which was seen as many as a problem with existing interpretations, such as the Copenhagen Interpretation.  

One of the implications of the austere interpretation (or "Many Worlds Interpretation") is that every quantum event, which we perceive as being probabalistic, splits the universe into many copies, each with a different outcome of the quantum event.  

The utility of this app is entirely dependent on this interpretation of quantum mechanics being correct. There is far from any consensus in the Physics community, but a growing number of influential Physicists are taking this idea very seriously.  

By using a quantum random number generator, this app will cause the universe to split into many universes, each with a different set of numbers in your possession. In one of those universes you will have the winning lottery numbers for your lottery of choice. Of course, it's not clear what is meant by "one" universe.  

The physicist Max Tegmark goes further to suggest "Quantum Immortality" whereby, any quantum event that might kill you will not subjectively happen, since you will only exist in universes where you are alive (that's a massive simplification). By extending supposition onto supposition, perhaps you are more likely to exist longer in a universe where you are rich?

### Usage

Build and run with
```
sbt run
```

Then 
```
http://localhost:8080/lotto?input=<parameters>
```

Where `params` is a comma separated list of # of generated numbers, and the max value of the numbers. For instance, if you want 6 numbers from 1-47 it would be

```
http://localhost:8080/lotto?input=6,47                      <- Irish Lotto
```

Or, if you want 5 numbers from 1-50 and 2 numbers from 1-12, it would be 

```
http://localhost:8080/lotto?input=5,50,2,12                 <- Euromillions
```


Good luck - you don't need it!