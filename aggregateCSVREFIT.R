#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v9-REFITKettle/CloserToWorst-10/"
args2 <- "/Users/farzamf/Desktop/SIPOS/datasets/v9-REFITKettle/raw/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))
index <- data.frame()

t <-list.files(paste(args2,userFiles1[1],sep = ""))
index <- strsplit(t,"[.]")[[1]][1]
for(i in 2:(length(userFiles1))){
  t <-list.files(paste(args2,userFiles1[i],sep = ""))
  index <- rbind(index,strsplit(t,"[.]")[[1]][1])
}
index[index == "1",1] <- 0.4258
index[index == "11",1] <- 0.3753
index[index == "12",1] <- 0.4241
index[index == "4",1] <- 0.3789
index[index == "8",1] <- 0.2137
index[index == "15",1] <- 0.4258

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  
  aggregate = data.frame()
  dev <- data.frame(read.csv(planFiles1[4],sep = ","))[1,]
  dev[,390:510] <- dev[,390:510]*as.numeric(index[i])
  dev[,1170:1290] <- dev[,1170:1290]*as.numeric(index[i])
  dev[2:10,] <- dev
  aggregate <- dev
  
  for(j in 1:3){
    dev <- data.frame(read.csv(planFiles1[j],sep = ","))[1,]
    dev[2:nrow(aggregate),] <- dev
    aggregate <- aggregate + dev
  }
  
  for(j in 5:length(planFiles1)){
    dev <- data.frame(read.csv(planFiles1[j],sep = ","))[1,]
    dev[2:nrow(aggregate),] <- dev
    aggregate <- aggregate + dev
  }
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())