
all:
	$(NOOP)

%.class:
	@scalac -language:implicitConversions -feature -deprecation $*.scala

%: %.class
	@scala $@

clean:
	rm *.class

