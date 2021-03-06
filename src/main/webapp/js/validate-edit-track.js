function isTrackNameValid() {
  var htmlElement = document.getElementById('name');
  var trackName = htmlElement.value;
  var trackNameRegExp = new RegExp('^.{1,255}$');
  var isElementValid = trackNameRegExp.test(trackName);
  var elem = $('#name').siblings('.validation-message');
  if (!isElementValid && !!trackName) {
    setDisabledCssClass(htmlElement);
    elem.addClass('visible');
  } else {
    removeDisabledCssClass(htmlElement);
    elem.removeClass('visible');
  }

  return isElementValid;
}

function isArtistNameValid() {
  var htmlElement = document.getElementById('artist');
  var artistName = htmlElement.value;
  var artistNameRegExp = new RegExp('^.{1,255}$');
  var isElementValid = artistNameRegExp.test(artistName);
  var elem = $('#artist').siblings('.validation-message');

  if (!isElementValid && !!artistName) {
    setDisabledCssClass(htmlElement);
    elem.addClass('visible');
  } else {
    elem.removeClass('visible');
    removeDisabledCssClass(htmlElement);
  }
  return isElementValid;
}

function isAlbumNameValid() {
  var htmlElement = document.getElementById('album');
  var albumName = htmlElement.value;
  var albumNameRegExp = new RegExp('^.{1,255}$');
  var isElementValid = albumNameRegExp.test(albumName);
  var elem = $('#album').siblings('.validation-message');

  if (!isElementValid && !!albumName) {
    setDisabledCssClass(htmlElement);
    elem.addClass('visible');
  } else {
    elem.removeClass('visible');
    removeDisabledCssClass(htmlElement);
  }

  return isElementValid;
}

function isPriceValueValid() {
  var htmlElement = document.getElementById('price');
  var priceValue = htmlElement.value;
  var priceValueRegExp = new RegExp('^\\d+([.]\\d{0,2})?$');
  var isElementValid = priceValueRegExp.test(priceValue);
  var elem = $('#price').siblings('.validation-message');

  if (!isElementValid && !!priceValue) {
    setDisabledCssClass(htmlElement);
    elem.addClass('visible');
  } else {
    elem.removeClass('visible');
    removeDisabledCssClass(htmlElement);
  }
  return isElementValid;
}

function setDisabledCssClass(htmlElement) {
  htmlElement.classList.add('disabled');
}

function removeDisabledCssClass(htmlElement) {
  htmlElement.classList.remove('disabled');
}

function isTrackParamsValid() {
  var isTrackNameAllowed = isTrackNameValid();
  var isArtistNameAllowed = isArtistNameValid();
  var isAlbumNameAllowed = isAlbumNameValid();
  var isPriceValueAllowed = isPriceValueValid();

  if (isTrackNameAllowed && isPriceValueAllowed && isArtistNameAllowed && isAlbumNameAllowed) {
    document.getElementById('button-save-track').removeAttribute('disabled');
  } else {
    document.getElementById('button-save-track').setAttribute('disabled', 'disabled');
  }
}
