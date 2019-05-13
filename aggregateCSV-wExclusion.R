#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noComp/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate <- aggregate + newData
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/Computer-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noDW/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/DishWasher-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noHob/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/Hob-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noKettle/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/Kettle-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noOven/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/Oven-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noTD/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/TumbleDryer-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################

#args = commandArgs(trailingOnly=TRUE)

args1 <- "/Users/farzamf/Desktop/SIPOS/datasets/v8-appExc/CloserToWorst-10/CloserToWorst-10-noWM/"

userFiles1 <- list.files(paste(args1,"detailedCSV/",sep = ""))

p <- 1
q <- 1
for(i in 1:(length(userFiles1))){
  if(q==5){
    p <- p+1
    q <- 1
  }
  planFiles1 <- list.files(paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],sep="/"),full.names = TRUE)
  aggregate = data.frame()
  aggregate <- data.frame(read.csv(planFiles1[1],sep = ","))
  for(j in 2:length(planFiles1)){
    newData <- data.frame(read.csv(planFiles1[j],sep = ","))
    aggregate[,-1] <- aggregate[,-1] + newData[,-1]
  }
  
  dev = data.frame()
  dev <- data.frame(read.csv(paste("/Users/farzamf/Desktop/SIPOS/datasets/v7/CloserToWorst-10/detailedCSV/",userFiles1[i],"/WashingMachine-schedules.csv",sep = ""),sep = ","))[1,]
  dev[2:nrow(aggregate),] <- dev
  aggregate <- aggregate + dev
  
  aggregate[,1] <- aggregate[1,length(planFiles1)+1]
  
  dir.create(paste(args1,"allAggregates/",sep = "") , showWarnings = FALSE)
  write.csv2(aggregate,paste(paste(args1,"detailedCSV/",sep = ""),userFiles1[i],"aggregatedPlan.csv",sep="/"))
  write.csv2(aggregate,paste(paste(args1,"allAggregates/",sep = ""),paste(paste("aggPlanUser",p,"day",q,sep = "-"),"csv",sep="."),sep="/"))
  q <- q+1
}

remove(list = ls())

################################