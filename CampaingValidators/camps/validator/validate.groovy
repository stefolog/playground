def campRoot = args[0]
def testCasesFile = new File("${campRoot}/tests.wiki")
def calculatorFile = new File("${campRoot}/Camp.groovy")
def specFile = new File("${campRoot}/spec.docx")

assert testCasesFile.exists()
assert calculatorFile.exists()
assert specFile.exists()

def points(amount) {
    new Camp().points(new Data(amount: amount)) 
}

def table = new WikiTable(file: testCasesFile,  columns: ["amount", "expected"])
def testCases = table.lines()

testCases.each { test -> 
	assert test.expected == points(test.amount)
}
println "\n\tOK (${testCases.size} test cases passed)"
