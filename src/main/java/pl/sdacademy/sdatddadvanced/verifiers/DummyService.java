package pl.sdacademy.sdatddadvanced.verifiers;

public class DummyService {

    private BeatifyService beatifyService;
    private DunderService dunderService;

    public DummyService(final BeatifyService beatifyService, final DunderService dunderService) {
        this.beatifyService = beatifyService;
        this.dunderService = dunderService;
    }

    public String dummifyString(final String value) {
        final String transformed = beatifyService.beautifyValue(value);

        return dunderService.dunderValue(transformed);
    }
}
