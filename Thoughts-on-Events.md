
# Interagency data relation

## Propose
Use Frequency as Target feature,

Catagory as Agency

## Process
### Per Agency
0. Frequency = count / (month, week, day, hour, min, second)
1. **Direct Plot** =  Frequency~t
2. **Trend** = Linear regress (Direct Plot )
3. Seasonality = Sine Cosine regress (Direct Plot )
4. Noise = Direct Plot/ (Trend * Seasonality)
5. **Irregularity** = outliers in Noise

### Inter Agency
6. **Correlation** = correlation(time of Irregularity per Agency ) 
7. Causation = if-time-latency(Correlation)

## Limit
Does not count any spatial data or feature other than temporal 

# Generalize Idea

## Propose
Use `Feature` as Target feature,

Catagory as `Catagory`

## Process
### Per `Catagory`
|#  |Tool  | Name           | =           | Problem |
| --| -----| ------------- |-------------|  --------| 
|0. |Spark |Stats |= cumulative-or-meadian `Feature` / (period)|Aggrigation of Big Data|
|1. |R.    |**Direct Plot** |=  Stats~t|Plot|
|2. |R.    |**Trend** |= Linear regress (Direct Plot )|Time Series Analysis|
|3. |R.    |Seasonality |= Sine Cosine regress (Direct Plot )|Time Series Analysis|
|4. |R.    |Noise |= Direct Plot/ (Trend * Seasonality)|Time Series Analysis|
|5. |?     |**Irregularity** |= outliers in Noise|Statistics|

### Inter `Catagory`
|#  |Tool  | Name           | =           | Problem |
| --| -----| -------------  |-------------| --------| 
|6. |?     |**Correlation** |= correlation(time and space-if-available of Irregularity per `Catagory` ) |unsupervised clustering|
|7. |?     |Causation |= if-time-latency(Correlation)|??|

