class WikiTable {
    def file;
    def columns;
    
    def lines() {
        def lines = file.readLines();
        lines[ 1 .. -1 ].collect { line -> parseLine(line) }
    }
    
    def parseLine(line) {
        def lineValues = line.split("\\|")[1, -1]
        lineValues = lineValues.collect { v -> new BigDecimal(v.trim()) }
        
        zip(columns, lineValues)
    }
    
    def zip(l1, l2) {
        [l1, l2].transpose().inject([:]) { map, row -> map << [(row[0]):row[1]] }
    }
}