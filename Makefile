
all:
	$(NOOP)

%.class:
	@scalac -deprecation $*.scala

%: %.class
	@scala $@

clean:
	rm *.class
