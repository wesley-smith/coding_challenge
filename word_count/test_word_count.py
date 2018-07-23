from word_count import word_count

def test_word_count():
    expected = {'2000': 1,
     'Green': 1,
     'Hop': 1,
     'Splash': 1,
     'and': 2,
     'cool': 1,
     'in': 2,
     'legs': 1,
     'lily': 1,
     'logs': 1,
     'on': 4,
     'pads': 1,
     'speckled': 1,
     'water': 2}
    filename = 'testfile.txt'
    assert expected == word_count(filename)