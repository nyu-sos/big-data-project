
# Baseline/Simplified Version: Interagency data relation

## Propose
Find Event relations according to time

## Process
### Per Agency
0. Frequency = event count / (month, week, day, hour, min, second)
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

### Declearation
Baseline model is just: Use `Event Frequency` as Target feature, `Agency` as Catagory

## Process
### Inner-`Catagory`
|#  |Tool  | Name           | =           | Problem |
| --| -----| ------------- |-------------|  --------| 
|0. |Spark |Stats |= _cumulative-or-meadian_ `Feature` / (_period_)|Aggrigation of Big Data|
|1. |R.    |**Direct Plot** |=  Stats~t|Plot|
|2. |R.    |**Trend** |= Linear regress (Direct Plot )|Time Series Analysis|
|3. |R.    |Seasonality |= Sine Cosine regress (Direct Plot )|Time Series Analysis|
|4. |R.    |Noise |= Direct Plot/ (Trend * Seasonality)|Time Series Analysis|
|5. |?     |**Irregularity** |= outliers in Noise|Statistics|

### Inter-`Catagory`
|#  |Tool  | Name           | =           | Problem |
| --| -----| -------------  |-------------| --------| 
|6. |?     |**Correlation** |= correlation(time _and space-if-available_ of Irregularity per `Catagory` ) |unsupervised clustering|
|7. |?     |Causation |= if-time-latency(Correlation)|??|

## Explaination on `Catagory` and `Feature` and `Time` and `Location`
### `Catagory`
Catagory must segment dataframe well 

e.g. 
`Agency` segments very likely different *data schemes*

### `Feature`
For `Inter-Catagory`, `Feature` must be commenly **effective** on both `Catagory`

**effective** means cleaned and dense

e.g.
`Event Frequency` is natually **effective**

### `Location`
needs to be cleaned

### `Time`
Period of `ssecond` even `minute` is not necessary on small datasets. 
