rm(TR10.Cost)

TR10.Cost <- read.csv("~/Desktop/SIPOS/Results/KettleExp/CtB10-Cost.csv", header = TRUE, stringsAsFactors = FALSE,sep = ",")

for (i in 2:nrow(TR10.Cost)){
  if (as.double(TR10.Cost[i,7]) > as.double(TR10.Cost[i,5])){
    TR10.Cost[i,7] <- TR10.Cost[i,5]
    if (as.double(TR10.Cost[i,7]) > as.double(TR10.Cost[i,5])){
      TR10.Cost[i,7] <- TR10.Cost[i,5]
  }
    
}
write.table(TR10.Cost, file = "/Users/farzamf/Desktop/CtB10-Cost.csv",row.names=FALSE,col.names=TRUE, sep=",")
