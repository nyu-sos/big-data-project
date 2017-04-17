count.by.second <- read.csv("data/count-by-second.csv")

row.names(count.by.second)<- as.character(count.by.second$Created.Date)
as.xts(count.by.second)
